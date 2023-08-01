package med.voll.alura.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

   private String logradouro;
   private String cep;
   private String bairro;
   private String cidade;
   private String uf;
   private String complemento;
   private String numero;

   public Endereco(DadosEndereco data) {
      this.logradouro = data.logradouro();
      this.cep = data.cep();
      this.bairro = data.bairro();
      this.cidade = data.cidade();
      this.uf = data.uf();
      this.complemento = data.complemento();
      this.numero = data.numero();
   }
}

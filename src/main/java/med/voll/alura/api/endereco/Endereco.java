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

   public Endereco(DadosEndereco dadosEndereco) {
      this.logradouro = dadosEndereco.logradouro();
      this.cep = dadosEndereco.cep();
      this.bairro = dadosEndereco.bairro();
      this.cidade = dadosEndereco.cidade();
      this.uf = dadosEndereco.uf();
      this.complemento = dadosEndereco.complemento();
      this.numero = dadosEndereco.numero();
   }
}

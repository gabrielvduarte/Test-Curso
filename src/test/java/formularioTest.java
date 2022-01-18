import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class formularioTest {

    protected formularioPage paginaFormulario;

    @BeforeEach
    public void beforeEach(){
        this.paginaFormulario = new formularioPage();
    }

    @AfterEach
    public void AfterEach(){
        paginaFormulario.fechar();
    }


    @Test
     public void cadastraComDadosValidos() {
        paginaFormulario.preencheFormulario("gabriel victor","gabriel58@gmail.com","12345678");
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));

    };
    @Test
    public void naoDeveriaCadastraComNomeInvalido(){
        paginaFormulario.preencheFormulario("gabriel","gabriel58@gmail.com","12345678");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeEmailInvalidos(){
        paginaFormulario.preencheFormulario("gabriel","gabriel58@","12345678");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeEmailSenhaInvalidos(){
        paginaFormulario.preencheFormulario("gabriel","gabriel58@g","12345");


        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComEmailinvalido(){
        paginaFormulario.preencheFormulario("gabriel victor","gabriel58@","12345678");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeSenhainvalidos(){
        paginaFormulario.preencheFormulario("gabriel","gabriel58@gmail.com","1234");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComSenhainvalido() {
        paginaFormulario.preencheFormulario("gabriel victor", "gabriel58@gmail.com", "1234");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeEmBrancoEmailSenhainvalido() {
        paginaFormulario.preencheFormulario("", "gabriel58@", "1234");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeEmailEmBrancoSenhainvalido() {
        paginaFormulario.preencheFormulario("", "", "1234");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo E-mail é obrigatório."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeEmBrancoEmailInvalido() {
        paginaFormulario.preencheFormulario("", "gabriel@", "12345678");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
        ;
    }

    @Test
    public void naoDeveriaCadastraComNomeEmailInvalidoSenhaEmBranco() {
        paginaFormulario.preencheFormulario("gabriel", "gabrie@", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
            Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeSenhaEmBrancoEmailInvalido() {
        paginaFormulario.preencheFormulario("", "gabrie@", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeSenhaEmailEmBranco() {
        paginaFormulario.preencheFormulario("", "", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo E-mail é obrigatório."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComNomeSenhaEmBranco() {
        paginaFormulario.preencheFormulario("", "gabrie@gmail.com", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Nome é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComEmailEmBrancoNomeSenhaInvalido() {
        paginaFormulario.preencheFormulario("gabriel", "", "12345");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um nome completo."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo E-mail é obrigatório."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("A senha deve conter ao menos 8 caracteres."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComSenhaEmBrancoEmailInvalido() {
        paginaFormulario.preencheFormulario("gabriel victor", "gabriel@", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Por favor, insira um e-mail válido."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComEmailSenhaEmBranco() {
        paginaFormulario.preencheFormulario("gabriel victor", "", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo E-mail é obrigatório."));
        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComSenhaEmBranco() {
        paginaFormulario.preencheFormulario("gabriel victor", "gabriel@gmail.com", "");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo Senha é obrigatório"));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void naoDeveriaCadastraComEmailEmBranco() {
        paginaFormulario.preencheFormulario("gabriel victor", "", "12345678");

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("O campo E-mail é obrigatório."));
        Assert.assertFalse(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
    }

    @Test
    public void cadastraComDadosValidosEVerificaOsDadosSalvos() {
        String nome = "gabriel victor";
        String email = "gabriel@gmail.com";
        String senha = "12345678";

        paginaFormulario.preencheFormulario(nome,email,senha);

        Assert.assertTrue(paginaFormulario.verifiqueSeExiste("Usuários cadastrados"));
        Assert.assertEquals(nome,paginaFormulario.pegaOtexto("tdUserName1"));
        Assert.assertEquals(email,paginaFormulario.pegaOtexto("tdUserEmail1"));
    };
}
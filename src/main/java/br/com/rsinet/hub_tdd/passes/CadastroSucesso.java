package br.com.rsinet.hub_tdd.passes;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.modulos.ModuloCadastro;
import br.com.rsinet.hub_tdd.modulos.ModuloHome;
import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroSucesso extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		ModuloHome.criarNovaConta(driver);

		ModuloCadastro.cadastrarUsuario(driver);
		
		String pass = CadastroPage.not_Password.getText();
		Assert.assertTrue(pass.equals("Confirm password"), "Cadastro efetuado com sucesso");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("CadastroSucesso ", driver);
		driver = fechaBrowser();
	}

}

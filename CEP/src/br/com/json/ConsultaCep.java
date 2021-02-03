package br.com.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static br.com.cep.es.EntradaESaida.*;

public class ConsultaCep {
	public static void main(String[] args) {
		obtemDados();

	}
	
	public static void obtemDados() {
		URL url;
		try {
			String cep = lerString("Informe o CEP", "Consulta de cep");
			url = new URL("https://viacep.com.br/ws/"+ cep + "/json");
			URLConnection con = url.openConnection();
			BufferedReader input = new BufferedReader(
			 new InputStreamReader(con.getInputStream(), "utf-8")
			);
			String line;
			String source = "";
			while((line = input.readLine()) != null)
				source += line;
			input.close();
			String[] dados = source.replace("{", "").replace("}", "").replace("\"", "").split(",");
			msgInfo(dados, "Consulta de CEP");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

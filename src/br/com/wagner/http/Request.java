package br.com.wagner.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request {

	public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//cliente http
		HttpClient cliente = HttpClient.newHttpClient();
		
		//criar a requisição
		HttpRequest requisicao = HttpRequest.newBuilder()
				.GET()
				.timeout(Duration.ofSeconds(60))
				.uri(URI.create(URL_GET))
				.build();
		
		// enviando uma solicitação
		HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
		
		// imprimir o conteúdo requisição
		System.out.println(resposta.statusCode());
		System.out.println(resposta.body());
	}
}

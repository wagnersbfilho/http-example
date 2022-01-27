package br.com.wagner.http;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.time.Duration;

public class Response {

	public static final String URL_POST = "https://httpbin.org/forms/post";
	public static final String FILE_JSON = "pedido.json";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//cliente http
		HttpClient cliente = HttpClient.newHttpClient();
		
		// criar resquisição
		HttpRequest requisicao = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
				.timeout(Duration.ofSeconds(60))
				.uri(URI.create(URL_POST))
				.build();
			
		//
		HttpClient cliente2 = cliente;
		cliente2.sendAsync(requisicao, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println);
		//	.join();
		
			
	}
}

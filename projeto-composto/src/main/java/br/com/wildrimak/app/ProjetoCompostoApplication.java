package br.com.wildrimak.app;

import br.com.wildrimak.app.models.Hello;
import br.com.wildrimak.app.models.World;

public class ProjetoCompostoApplication {
	
	public static void main(String[] args){
		
		Hello hello = new Hello();
		World world = new World();

		System.out.println(hello.getHello() + world.getWorld());
	}
}

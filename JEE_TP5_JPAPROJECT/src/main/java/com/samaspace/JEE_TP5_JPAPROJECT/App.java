package com.samaspace.JEE_TP5_JPAPROJECT;

import com.samaspace.clientdao.ClientManager;
import com.samaspace.entities.Client;

public class App 
{
    public static void main( String[] args )
    {
        
    	Client client = new Client("Oussama", "Maroc");
    	ClientManager C= new ClientManager();
    	C.ajouterClient(client);
    	//Client client1 = new Client("John", "New York");
    	//Client client2 = new Client("hawkander", "Canada");
    	//ClientManager.ajouterClient(client2);
    	
    	//Client c = new Client(1,"kkk", "sdsdsd");
    	//ClientManager.supprimerClientV2(7);
    	//ClientManager.modifierClient(c);
    	
    	//ClientManager.consulter(client2, 2);
    	//ClientManager.supprimerClientV2(3);
    	//ClientManager.ListerTous();
    	//ClientManager.ListerByName("h");
    	
    	//ClientManager.modifierClientV2(4, "hawkander", "Uk");
    	
    	
    	
    	
    	
    }
}

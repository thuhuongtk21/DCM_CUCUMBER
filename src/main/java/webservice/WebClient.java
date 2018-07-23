package webservice;
import java.net.URL;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WebClient {

    @WebService(name = "HelloWeb", targetNamespace = "https://coreapi.cert.heb.com:8443/SOAP/v1/OfferService")
    public interface HelloWeb {
        @WebMethod
        String sayGreeting(String name);
    }

    public static void main(String[] args) throws Exception {
        Service serv = Service.create(new URL(
                "https://coreapi.cert.heb.com:8443/SOAP/v1/OfferService?wsdl"), 
                new QName("https://coreapi.cert.heb.com:8443/SOAP/v1/OfferService", "addLocBasketToDealHeader"));
        HelloWeb p = serv.getPort(HelloWeb.class);
        System.out.println(p.sayGreeting("John"));
    }
}
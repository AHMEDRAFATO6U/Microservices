package com.example.ecomorderservice.service;

import com.example.ecomorderservice.client.InventoryClient;
import com.example.ecomorderservice.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
@RequiredArgsConstructor
public class OrderService {
//    private final RestTemplate restTemplate;
    private final RestClient restClient;

    private final InventoryClient inventoryClient;





    public String palceOrder(Long productId) {
//        String response = restTemplate.getForObject(
//                "http://localhost:8081/Inventory/"+productId ,
//                String.class
//        );


//        ResponseEntity<InventoryResponse> entity = restClient.get()
//                .uri("http://localhost:8081/Inventory/{productId}" ,productId)
//                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
//                    throw new MyCustomRuntimeException( "Inventory service returned error",response.getStatusCode() , response.getHeaders());
//                })
//                .toEntity(InventoryResponse.class);
//
//        System.out.println("STATUS: " + entity.getStatusCode());
//
//        System.out.println("BODY: [" + entity.getBody() + "]");

//       Object exchange= restClient.get()
//                .uri("http://localhost:8081/Inventory/{productId}", productId)
//                .exchange((HttpRequest clientRequest, RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse clientResponse) -> {
//                    if (clientResponse.getStatusCode().is4xxClientError()) {
//                        throw new MyCustomRuntimeException(clientResponse.getStatusCode(), clientResponse.getHeaders());
//                    } else {
//                        return clientResponse.getBody();
//                    }
//                })




        InventoryResponse inventoryResponse = inventoryClient.getInventory(productId);
        int quantity = inventoryResponse.getQuantity();
        updateInventory(inventoryResponse);

        return quantity>0 ?
                "ORDER PLACED SUCCESSFULLY" :
                "ORDER OUT OF STOCK";
    }

    private void updateInventory(InventoryResponse response) {
        response.setQuantity(response.getQuantity()-1);
        inventoryClient.updateInventory(response);

//        restClient.post()
//                .uri("http://localhost:8081/Inventory")
//                .body(response)
//                .retrieve()
//                .toBodilessEntity();
    }
}

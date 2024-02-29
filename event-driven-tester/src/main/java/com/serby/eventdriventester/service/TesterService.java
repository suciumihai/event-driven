package com.serby.eventdriventester.service;

import com.serby.basedomains.dto.OrderDto;
import com.serby.eventdriventester.command.GetOrderByUUIDCommand;
import com.serby.eventdriventester.command.GetOrdersByNameCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TesterService {

    private ApiClient apiClient;

    private GetOrderByUUIDCommand getOrderByUUIDCommand;

    private GetOrdersByNameCommand getOrdersByNameCommand;

    public OrderDto getOrderByUUID(String uuid) {
        return apiClient.findOrderByUUID(uuid).getBody();
    }

    public List<OrderDto> getOrdersByName(String name) {
        return apiClient.findOrdersByName(name).getBody();
    }

    //command pattern: se adauga comand clas, se parametrizeaza ca obiecte,
    //callerul, adica serviciul este decuplat de execution logic: open / close principle
    //fiecare comanda se oucpa de un call logic: singel reposnibility principle
    //new endpoit testes, se adauga usor new commnds: easier mantenance si extensibility
    public ResponseEntity<String> executeCommand(String commandName, String inputValue) {
        switch (commandName) {
            case "getOrderByUUID":
                return getOrderByUUIDCommand.execute(inputValue);
            case "getOrdersByName":
                return getOrdersByNameCommand.execute(inputValue);
            default:
                throw new IllegalArgumentException("invalid endpoint name");
        }
    }
}

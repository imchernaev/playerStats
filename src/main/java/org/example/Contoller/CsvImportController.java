package org.example.Contoller;


import org.example.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/import")
public class CsvImportController {

    @Autowired
    private DataService dataService;

    @GetMapping("/load")
    public String loadCSVData() {
        dataService.importData();
        return "Data from csv imported.";
    }
}

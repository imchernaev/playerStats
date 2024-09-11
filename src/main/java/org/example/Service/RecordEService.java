package org.example.Service;

import org.example.Entity.RecordE;
import org.example.Repository.RecordERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordEService {

    @Autowired
    private RecordERepository recordRepository;


//    public RecordE saveRecord(RecordE record) {
//        return recordRepository.save(record);
//    }


    public List<RecordE> getAllRecords() {
        return recordRepository.findAll();
    }


    public RecordE getRecordById(int recordId) {
        return recordRepository.findById(recordId).orElse(null);
    }


//    public void deleteRecord(int recordId) {
//        recordRepository.deleteById(recordId);
//    }
}

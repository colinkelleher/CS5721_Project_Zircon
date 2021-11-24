package CS5721.project.records.service;

import CS5721.project.records.entity.Records;
import CS5721.project.records.entity.RecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecordsService {

    @Autowired
    private RecordsDAO<Records> recordsDAO;

    public ArrayList<Records> findAllRecords(){
        return recordsDAO.findAllRecords();
    }
}

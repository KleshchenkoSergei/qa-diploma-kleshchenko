package ru.netology.data.sql;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SQLCreditData {
    String id;
    String bank_id;
    String created;
    String status;
}

package ru.netology.data.sql;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SQLPaymentData {
    String id;
    String amount;
    String created;
    String status;
    String transaction_id;
}

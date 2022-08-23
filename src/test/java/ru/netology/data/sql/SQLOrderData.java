package ru.netology.data.sql;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SQLOrderData {
    String id;
    String created;
    String credit_id;
    String payment_id;
}

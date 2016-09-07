CREATE TABLE if NOT EXISTS account (
    account_id INT NOT NULL,
    balance INT NOT NULL,

    PRIMARY KEY (account_id)
);

CREATE TABLE if NOT EXISTS income (
    income_id INT NOT NULL,
    income_type INT NOT NULL,
    income_desc VARCHAR NOT NULL,
    income_amount INT NOT NULL,

    PRIMARY KEY (income_id),
    FOREIGN KEY (income_id) REFERENCES account(account_id)
);

CREATE TABLE if NOT EXISTS expenditure (
    expenditure_id INT NOT NULL,
    expenditure_type INT NOT NULL,
    expenditure_desc VARCHAR NOT NULL,
    expenditure_amount INT NOT NULL,

    PRIMARY KEY (expenditure_id),
    FOREIGN KEY (expenditure_id) REFERENCES account(account_id)
);
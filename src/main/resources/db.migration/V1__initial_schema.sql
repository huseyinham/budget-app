CREATE TABLE if NOT EXISTS account (
    id NUMERIC NOT NULL,
    balance NUMERIC NOT NULL,
    income NUMERIC NOT NULL,
    expenditure NUMERIC NOT NULL,

    PRIMARY KEY (id)
);
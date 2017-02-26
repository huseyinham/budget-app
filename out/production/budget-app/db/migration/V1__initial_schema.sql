CREATE TABLE if NOT EXISTS account (
    id INT NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE if NOT EXISTS income (
    id INT NOT NULL,
    type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    account_id INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE TABLE if NOT EXISTS expenditure (
    id INT NOT NULL,
    type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    account_id INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account(id)
);
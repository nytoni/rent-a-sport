-- Database schema for Rent-A-Sport
-- Created by: Toni-Ann Plowright
-- CSCI 4300 Term Project- Team 9
-- Change bundles.imagePath to path of picture on your local comp

CREATE TABLE user
(
customerId      int             AUTO_INCREMENT PRIMARY KEY,
name            varchar(255)    NOT NULL ,
password        varchar(255)    NOT NULL ,
email           varchar(255)    NOT NULL 
);
ALTER TABLE user AUTO_INCREMENT = 1001;

CREATE TABLE bundles
(   
bundleName      varchar(255)    UNIQUE PRIMARY KEY,
quantity        int             NOT NULL,
items           varchar(255)    NOT NULL,
price_wk        int             NOT NULL,
price_2wk       int             NOT NULL,
price_mnth      int             NOT NULL,
price_3mnth     int             NOT NULL,
price_6mnth     int             NOT NULL,
imagePath       varchar(255),
    
CHECK(quantity>0)
);

CREATE TABLE account
( 
customerId      int             UNIQUE PRIMARY KEY,
creditName      varchar(255)    NOT NULL,
shippingAddr    varchar(255)    NOT NULL,
billingAddr     varchar(255)    NOT NULL,
cardNum         varchar(255)    NOT NULL,
expirationDate  varchar(255)    NOT NULL,
securityCode    varchar(255)    NOT NULL,
    
FOREIGN KEY(customerId) REFERENCES user(customerId)
);

CREATE TABLE orders
( 
orderNum        int             AUTO_INCREMENT PRIMARY KEY,
customerId      int             NOT NULL,
shipDate        date            NOT NULL,
arrivalDate     date            NOT NULL,
price           int             NOT NULL,
itemsInOrder    int             NOT NULL,
conditionStat   varchar(255)    NOT NULL,
dueDate         date            NOT NULL,
orderStatus     varchar(255)    NOT NULL,
    
FOREIGN KEY(customerId) REFERENCES user(customerId)
);
ALTER TABLE orders AUTO_INCREMENT = 80801;

CREATE TABLE cart
(   
customerId      int             NOT NULL,
orderNum        int             ,
bundleName      varchar(255)    NOT NULL,
quantity        int             NOT NULL,
timePeriod      varchar(255)    NOT NULL, 
    
FOREIGN KEY(customerId) REFERENCES user(customerId),    
FOREIGN KEY(orderNum) REFERENCES orders(orderNum)
);

SET FOREIGN_KEY_CHECKS=0;

INSERT INTO user VALUES(default, 'Jane Doe', 'psswd', 'jane@yahoo.com');
INSERT INTO user VALUES(default, 'Fred Douglas','ps123','fred@yahoo.com');
INSERT INTO bundles VALUES('camping', 10, 
                            'tent,pack,head lamp, sleeping bag', 
                            50,75,100,125,150,
                            'https://qmkit.co.uk/729/425.jpg');
INSERT INTO bundles VALUES('soccer', 8, 
                            'soccer ball, cones, clones, field goal',
                            50,75,100,125,150,  'https://www.3qsports.co.uk/userfiles/lg_images/Mitre_Football_Training_Pack_Clearance-CI9ixi.jpg');
INSERT INTO bundles VALUES('football', 13, 
                            'football, flags, knee pads',
                            50,75,100,125,150, 'http://media.staps.nantes.free.fr/L3EM_G1/David/res/L-equipement-d-un-joueur.jpg');
INSERT INTO bundles VALUES('baseball', 10, 
                            'baseball, bat, gloves',
                            50,75,100,125,150, 'http://www.arseventsusa.com/assets/baseball_equpiment.jpg');
INSERT INTO bundles VALUES('volleyball', 10, 
                            'volleyball, knee pads',
                            50,75,100,125,150, 'http://www.kbacoach.com/images/promo/2/kba_volleyball_banner.jpg');
                           
INSERT INTO account VALUES((select customerId from user where name = 'Jane Doe'),'Jane Dougie', '123 Main Road','123 Main Road', '1000 2222 3333 4444', '05/2017', '201'); 
INSERT INTO account VALUES((select customerId from user where name = 'Fred Douglas'), 'Fredrick TheMan', '123 Main Road','123 Main Road', '1111 2222 3333 4444', '2017-01-00', '201');
INSERT INTO orders VALUES(default, (select customerId from user where name = 'Jane Doe'), CURDATE(),'2016-11-20', 200, 3,'good', '2016-12-13', 'open');
INSERT INTO orders VALUES(default, (select customerId from user where name = 'Jane Doe'), CURDATE(),'2016-11-20', 500, 2,'fair', '2016-12-13', 'closed');

INSERT INTO cart VALUES((select customerId from user where name = 'Jane Doe'),(select orderNum from orders JOIN user ON user.customerId=orders.customerId where user.name= 'Jane Doe' and orders.orderStatus= 'open'), 'camping', 2, 'price_mnth');

INSERT INTO cart VALUES((select customerId from user where name = 'Jane Doe'),(select orderNum from orders JOIN user ON user.customerId=orders.customerId where user.name= 'Jane Doe' and orders.orderStatus= 'open'), 'football', 1, 'price_wk');
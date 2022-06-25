DROP DATABASE IF EXISTS "RepAgent";

CREATE DATABASE "RepAgent";

CREATE TABLE "Person" (
                                    "id" INT NOT NULL,
                                    "name" varchar(45) NOT NULL,
                                    "email" varchar(45) NOT NULL,
                                    "passwd" varchar(45) NOT NULL,
                                    "money" DECIMAL(9,2) NOT NULL,
                                    "Role_access_level" serial NOT NULL,
                                    CONSTRAINT "Person_pk" PRIMARY KEY ("id")
   ) WITH (
         OIDS=FALSE
    );



CREATE TABLE "Review" (
                                 "ReviewId" integer NOT NULL,
                                 "Content" varchar(45) NOT NULL,
                                 "DateWorkDone" TIME NOT NULL,
                                 "Rating" DECIMAL NOT NULL,
                                 "Person_id" integer NOT NULL,
                                 "Order_id" integer NOT NULL,
                                 CONSTRAINT "Review_pk" PRIMARY KEY ("ReviewId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Order" (
                                "id" INT NOT NULL,
                                "title" VARCHAR(45) NOT NULL,
                                "description" VARCHAR(45) NOT NULL,
                                "cost" DECIMAL(9,2) NOT NULL,
                                "Payment_id" INT NOT NULL,
                                "WorkStatus_id" INT NOT NULL,
                                CONSTRAINT "Order_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Role" (
                               "access_level" INT NOT NULL,
                               "roleName" VARCHAR(45) NOT NULL
) WITH (
      OIDS=FALSE
    );


CREATE TABLE "Payment" (
                                  "id" INT NOT NULL,
                                  "PaymentName" VARCHAR(45) NOT NULL
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "WorkStatus" (
                                     "id" INT NOT NULL,
                                     "WorkStatusName" VARCHAR(45) NOT NULL
) WITH (
      OIDS=FALSE
    );



ALTER TABLE "Person" ADD CONSTRAINT "Person_fk0" FOREIGN KEY ("Role_access_level") REFERENCES "Role"("access_level");

ALTER TABLE "Review" ADD CONSTRAINT "Review_fk0" FOREIGN KEY ("Person_id") REFERENCES "Person"("id");
ALTER TABLE "Review" ADD CONSTRAINT "Review_fk1" FOREIGN KEY ("Order_id") REFERENCES "Order"("id");

ALTER TABLE "Order" ADD CONSTRAINT "Order_fk0" FOREIGN KEY ("Payment_id") REFERENCES "Payment"("id");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk1" FOREIGN KEY ("WorkStatus_id") REFERENCES "WorkStatus"("id");
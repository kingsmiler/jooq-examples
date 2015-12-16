DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS prefecture;

CREATE TABLE IF NOT EXISTS actor (
  id            INT          NOT NULL AUTO_INCREMENT,
  name          VARCHAR(30)  NOT NULL,
  height        SMALLINT,
  blood         VARCHAR(2),
  birthday      DATE,
  birthplace_id SMALLINT,
  update_at     TIMESTAMP(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE CURRENT_TIMESTAMP (6),
  PRIMARY KEY (id)
)
  ENGINE = INNODB;


CREATE TABLE IF NOT EXISTS prefecture (
  id   SMALLINT   NOT NULL,
  name VARCHAR(6) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = INNODB;

CREATE TABLE blog (
  id VARCHAR(50) PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  url VARCHAR(200) NOT NULL,
  content VARCHAR(10000) NOT NULL,
  indexedAt datetime NOT NULL
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

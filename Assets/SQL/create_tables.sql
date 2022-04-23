CREATE TABLE Business (
  business_id varchar(22) not null,
  name varchar(100) not null,
  review_count smallint,
  stars decimal (2,1),
  category varchar(1000),
  Primary key(business_id));

CREATE TABLE Address (
	business_id varchar(22) not null,
	street varchar(100) not null,
	city varchar(100) not null,
	state varchar(2) not null,
  zip varchar(5) not null,
  foreign key(business_id) references Business(business_id));

CREATE TABLE Hours (
  business_id varchar(22) not null,
  monday varchar(20) DEFAULT "Closed",
  tuesday varchar(20) DEFAULT "Closed",
  wednesday varchar(20) DEFAULT "Closed",
  thursday varchar(20) DEFAULT "Closed",
  friday varchar(20) DEFAULT "Closed",
  saturday varchar(20) DEFAULT "Closed",
  sunday varchar(20) DEFAULT "Closed",
  foreign key(business_id) references Business(business_id));

CREATE TABLE User (
  user_id varchar(22) not null,
  name varchar(100) not null,
  review_count smallint,
  primary key(user_id)
);

CREATE TABLE Review (
  review_id varchar(22) not null,
  business_id varchar(22) not null,
  user_id varchar(22) not null,
  text text not null,
  date varchar(30),
  stars decimal (2,1),
  primary key(review_id),
  foreign key(business_id) references Business(business_id),
  foreign key(user_id) references User(user_id)
);

CREATE TABLE Tip (
  text text not null,
  compliment_count smallint,
  date varchar(30),
  business_id varchar(22) not null,
  user_id varchar(22) not null,
  foreign key(business_id) references Business(business_id),
  foreign key(user_id) references User(user_id)
);

CREATE TABLE Photo (
  photo_id varchar(22) not null,
  business_id varchar(22) not null,
  caption text,
  label varchar(100)
);

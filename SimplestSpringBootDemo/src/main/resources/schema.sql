create table contacts(
  id IDENTITY,
  firstName VARCHAR (30) not null,
  lastName VARCHAR (50) not null,
  phoneNumber VARCHAR (13),
  emailAddress varchar(30)
);
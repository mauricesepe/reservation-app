create table Reservation_Participants_Bookings (
	companyId LONG not null,
	bookingId LONG not null,
	participantId LONG not null,
	primary key (bookingId, participantId)
);

create table Reservation_PersistedAmenity (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	amenityId LONG not null primary key,
	name VARCHAR(75) null,
	companyId LONG
);

create table Reservation_PersistedBooking (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	bookingId LONG not null primary key,
	calendarBookingId LONG,
	title VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	roomId LONG,
	description VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Reservation_PersistedOffice (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	officeId LONG not null primary key,
	calendarResourceId LONG,
	name VARCHAR(75) null,
	location VARCHAR(75) null,
	roomCount INTEGER,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Reservation_PersistedParticipant (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	participantId LONG not null primary key,
	userId LONG,
	fullName VARCHAR(75) null,
	companyName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	companyId LONG
);

create table Reservation_PersistedPurpose (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	purposeId LONG not null primary key,
	name VARCHAR(75) null,
	companyId LONG
);

create table Reservation_PersistedRoom (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	roomId LONG not null primary key,
	calendarId LONG,
	name VARCHAR(75) null,
	photoPath VARCHAR(255) null,
	availableMonday BOOLEAN,
	availableTuesday BOOLEAN,
	availableWednesday BOOLEAN,
	availableThursday BOOLEAN,
	availableFriday BOOLEAN,
	availableSaturday BOOLEAN,
	availableSunday BOOLEAN,
	availableStartTime INTEGER,
	availableEndTime INTEGER,
	officeId LONG,
	capacitySquareMeters DOUBLE,
	capacityPeople INTEGER,
	phoneExtension INTEGER,
	wifiSSID VARCHAR(75) null,
	wifiSecurityType INTEGER,
	wifiPassword VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Reservation_Rooms_Amenities (
	companyId LONG not null,
	amenityId LONG not null,
	roomId LONG not null,
	primary key (amenityId, roomId)
);

create table Reservation_Rooms_Purposes (
	companyId LONG not null,
	purposeId LONG not null,
	roomId LONG not null,
	primary key (purposeId, roomId)
);
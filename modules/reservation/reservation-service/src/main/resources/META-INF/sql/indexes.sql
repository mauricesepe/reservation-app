create index IX_AB765DBC on Reservation_Participants_Bookings (companyId);
create index IX_B8086C72 on Reservation_Participants_Bookings (participantId);

create index IX_DA858BF4 on Reservation_PersistedAmenity (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_F0A5EFD3 on Reservation_PersistedAmenity (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_9DBCB594 on Reservation_PersistedBooking (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_A1D53F89 on Reservation_PersistedBooking (roomId);
create index IX_9C47B279 on Reservation_PersistedBooking (userId);
create index IX_59A45973 on Reservation_PersistedBooking (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_FF789BB7 on Reservation_PersistedOffice (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_42BEE596 on Reservation_PersistedOffice (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_4014076E on Reservation_PersistedParticipant (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_767E9F4D on Reservation_PersistedParticipant (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_22796BD9 on Reservation_PersistedPurpose (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_445839B8 on Reservation_PersistedPurpose (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_40DF122E on Reservation_PersistedRoom (calendarId);
create index IX_3DD72256 on Reservation_PersistedRoom (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_904D1B6C on Reservation_PersistedRoom (officeId);
create index IX_7F648A35 on Reservation_PersistedRoom (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_2D80EE05 on Reservation_Rooms_Amenities (companyId);
create index IX_243E908D on Reservation_Rooms_Amenities (roomId);

create index IX_5A9C0353 on Reservation_Rooms_Purposes (companyId);
create index IX_53562DFF on Reservation_Rooms_Purposes (roomId);
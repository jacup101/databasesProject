SELECT BulkColumn FROM OPENROWSET (BULK `\businesses.JSON`, SINGLE_CLOB) as import;
-- SELECT value FROM OPENROWSET (BULK 'C:\businesses.json', SINGLE_CLOB) as j
--  CROSS APPLY OPENJSON(BulkColumn);

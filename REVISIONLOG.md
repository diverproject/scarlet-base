# Revision Log

## Example

```
{DATE}

{COMMIT MESSAGE}
{COMMIT MESSAGE}

{DATE}

{COMMIT MESSAGE}
...
```

## Date

**Format:** YYYY-MM-DD

## COMMIT MESSAGE

```
{VERSIONING} {ISSUE}
{SUMMARY}
```

## VERSIONING

```
{MAJOR.MINOR.BUGFIX.BUILD}
```

- **MAJOR:** major version
- **MINOR:** minor version
- **BUGFIX:** bug fix number
- **BUILD:** build number is sequencial (don't make part of a real versioning)

## SUMMARY:

```
- {VERB/ACTION} {CONTENT}
	- {ADDITIONAL OBSERVATIONS/COMMENTS}
```

- **Verb/Action:** added, fixed, upped, removed, switched, improved, updated, renamed
- **Content:** a message to describe a resume about what was made.
- **Additional Observations/Comments:** a *"free"* message to specify with more details what was made, use it on large and/or complex changes.

# Logs

## 2019-10-07

### 0.1.2.14
- Changed project java version of 13 to 10.

### 0.1.2.13
- Fixed DisplayName annotation name of testPercentage() on TestStatisticUtils.

### 0.1.1.12
- Change project settings of Eclipse to IntelliJ.

## 2019-10-03

### 0.1.1.11
- Added hasMinLength() and hasMaxLength() on StringUtils to check string length consider null values as false.

### 0.1.1.10
- Updated project java version of 11 to 12.

### 0.1.1.9
- Added hasBetween() on StringUtils to check string length consider null values as false.

## 2019-09-28

### 0.1.1.8
- Added method to get size of collection or return 0 (zero) when null.

## 2019-09-14

### 0.1.1.7
- Update eclipse project settings.

### 0.1.1.6
- Fixed use of nvl() on Bitwise classes, DoubleParser and FloatParser.
- Updated code format of DoubleParser and FloatParser.

## 2019-09-13

### 0.1.0.5
- Removed 'classz' parameter from nvl() on ScarletUtils because it is not necessary.

## 2019-09-09

### 0.1.0.4
- Added Bitwise.toString() static method to describe a bitwise properties.

## 2019-08-29

### 0.1.0.3
- Added varLowerCase() and varUpperCase() on StringUtils.

## 2019-08-27

### 0.1.0.2
- Added capitalize() and uncapitalize() methods on StringUtils.

### 0.1.0.1
- Initial project version.
- Added utilities class for Array, Char, String, Numbers, Bitwise and more.
- Added support for any language text messages with Language interface and LanguageReader.
- JUnit tests included.
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

## 2019-08-27

### 0.1.0.2
- Added capitalize() and uncapitalize() methods on StringUtils.

### 0.1.0.1
- Initial project version.
- Added utilities class for Array, Char, String, Numbers, Bitwise and more.
- Added support for any language text messages with Language interface and LanguageReader.
- JUnit tests included.
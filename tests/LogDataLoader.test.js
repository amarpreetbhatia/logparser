const LogDataLoader = require('../src/services/LogDataLoader');
const path = require('path');

describe('LogDataLoader', () => {
  test('should parse log lines correctly', () => {
    const sampleLog = '177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] "GET /intranet-analytics/ HTTP/1.1" 200 3574';
    const result = LogDataLoader.parseLogLines(sampleLog);
    
    expect(result).toHaveLength(1);
    expect(result[0].ipAddress).toBe('177.71.128.21');
    expect(result[0].url).toBe('/intranet-analytics/');
    expect(result[0].httpStatus).toBe(200);
    expect(result[0].date).toBeInstanceOf(Date);
  });

  test('should handle invalid log lines', () => {
    const invalidLog = 'This is not a valid log line';
    const result = LogDataLoader.parseLogLines(invalidLog);
    
    expect(result).toHaveLength(0);
  });
});

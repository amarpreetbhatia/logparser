const DateConverterUtil = require('../src/utils/DateConverterUtil');

describe('DateConverterUtil', () => {
  test('should parse log date format correctly', () => {
    const dateStr = '[10/Jul/2018:22:21:28 +0200]';
    const result = DateConverterUtil.parseLogDate(dateStr);
    
    expect(result).toBeInstanceOf(Date);
    expect(result.getUTCFullYear()).toBe(2018);
    expect(result.getUTCMonth()).toBe(6); // July is 6 (zero-based)
    expect(result.getUTCDate()).toBe(10);
    expect(result.getUTCHours()).toBe(22);
    expect(result.getUTCMinutes()).toBe(21);
    expect(result.getUTCSeconds()).toBe(28);
  });
});

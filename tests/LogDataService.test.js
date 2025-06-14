const LogDataService = require('../src/services/LogDataService');
const LogData = require('../src/models/LogData');

// Mock LogDataLoader
jest.mock('../src/services/LogDataLoader', () => ({
  loadLogData: jest.fn(() => [
    new LogData('192.168.1.1', new Date(), '/url1', 200),
    new LogData('192.168.1.2', new Date(), '/url2', 200),
    new LogData('192.168.1.1', new Date(), '/url1', 200),
    new LogData('192.168.1.3', new Date(), '/url3', 404),
    new LogData('192.168.1.2', new Date(), '/url2', 200),
  ])
}));

describe('LogDataService', () => {
  let logDataService;

  beforeEach(() => {
    logDataService = new LogDataService();
    logDataService.loadData();
  });

  test('should count unique IPs correctly', () => {
    const uniqueIpCount = logDataService.getUniqueIpCount();
    expect(uniqueIpCount).toBe(3);
  });

  test('should get top URLs correctly', () => {
    const topUrls = logDataService.getTopUrls(2);
    expect(topUrls).toEqual(['/url1', '/url2']);
  });

  test('should get top IPs correctly', () => {
    const topIps = logDataService.getTopIps(2);
    expect(topIps).toEqual(['192.168.1.1', '192.168.1.2']);
  });
});

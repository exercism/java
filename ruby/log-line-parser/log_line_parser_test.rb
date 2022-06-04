# frozen_string_literal: true

require 'minitest/autorun'
require_relative 'log_line_parser'

class LogLineParserTest < Minitest::Test
  def test_error_message
    assert_equal 'Stack overflow', LogLineParser.new('[ERROR]: Stack overflow').message
  end

  def test_warning_message
    assert_equal 'Disk almost full', LogLineParser.new('[WARNING]: Disk almost full').message
  end

  def test_info_message
    assert_equal 'File moved', LogLineParser.new('[INFO]: File moved').message
  end

  def test_message_with_leading_and_trailing_space
    assert_equal 'Timezone not set', LogLineParser.new("[WARNING]:   \tTimezone not set  \r\n").message
  end

  def test_error_log_level
    assert_equal 'error', LogLineParser.new('[ERROR]: Disk full').log_level
  end

  def test_warning_log_level
    assert_equal 'warning', LogLineParser.new('[WARNING]: Unsafe password').log_level
  end

  def test_info_log_level
    assert_equal 'info', LogLineParser.new('[INFO]: Timezone changed').log_level
  end

  def test_error_reformat
    assert_equal 'Segmentation fault (error)', LogLineParser.new('[ERROR]: Segmentation fault').reformat
  end

  def test_warning_reformat
    assert_equal 'Decreased performance (warning)', LogLineParser.new('[WARNING]: Decreased performance').reformat
  end

  def test_info_reformat
    assert_equal 'Disk defragmented (info)', LogLineParser.new('[INFO]: Disk defragmented').reformat
  end

  def test_reformat_with_leading_and_trailing_space
    assert_equal 'Corrupt disk (error)', LogLineParser.new("[ERROR]: \t Corrupt disk\t \t \r\n").reformat
  end
end

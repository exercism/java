class LogLineParser
  def initialize(line)
    @line = line
  end

  def message
    @message ||= @line.split(':', 2)[1].strip
  end

  def log_level
    @line.split(':', 2)[0].strip.delete_prefix('[').delete_suffix(']').downcase
  end

  def reformat
    "#{message} (#{log_level})"
  end
end

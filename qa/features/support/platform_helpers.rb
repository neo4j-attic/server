module PlatformHelpers


  ## TODO use better enum-pattern in ruby
  class Platform
    attr_reader :type, :extension

    def initialize(type, extension)
      @type = type
      @extension = extension
    end

    WINDOWS = Platform.new('windows', 'zip')
    UNIX = Platform.new('unix', 'tar.gz')
    UNKNOWN = Platform.new('unknown', nil)

    def windows?
      type == WINDOWS.type
    end

    def mac?
      type == UNIX.type
    end

    def unknown?
      type == UNKNOWN.type
    end
  end


  def current_platform
    if RUBY_PLATFORM =~ /win32/
      Platform::WINDOWS
    elsif RUBY_PLATFORM =~ /linux/ || RUBY_PLATFORM =~ /darwin/ || RUBY_PLATFORM =~ /freebsd/
      Platform::UNIX
    else
      Platform::UNKNOWN
    end
  end

end

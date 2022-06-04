class Attendee
  attr_reader :height, :pass_id

  def initialize(height)
    @height = height
    @pass_id = nil
  end

  def issue_pass!(pass_id)
    @pass_id = pass_id
  end

  def revoke_pass!
    @pass_id = nil
  end
end

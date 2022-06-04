require 'minitest/autorun'
require_relative 'attendee'

class AttendeeTest < Minitest::Test
  def test_new_instance
    height = 100
    assert_equal Attendee, Attendee.new(height).class
  end

  def test_new_instance_height
    height = 100
    assert_equal height, Attendee.new(height).height
  end

  def test_new_instance_pass_id
    height = 100
    assert_nil Attendee.new(height).pass_id
  end

  def test_issue_pass
    height = 100
    attendee = Attendee.new(height)

    pass_id = 1
    attendee.issue_pass!(pass_id)

    assert_equal pass_id, attendee.pass_id
  end

  def test_has_pass_after_revoked
    height = 100
    attendee = Attendee.new(height)
    pass_id = 1
    attendee.issue_pass!(pass_id)
    attendee.revoke_pass!
    refute attendee.pass_id
  end
end

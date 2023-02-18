def new_remote_control_car:
  # Populate the object with the required attributes
  {
      "battery_percentage": 100,
      "distance_driven_in_meters": 0,
      "nickname": null
  }
;

def new_remote_control_car(nickname):
  # Populate the object with the required attributes
  {
      "battery_percentage": 100,
      "distance_driven_in_meters": 0,
      "nickname": nickname
  }
;

def display_distance:
  # Implement the required output string
  (.distance_driven_in_meters | tostring) + " meters"
;

def display_battery:
  # Implement the required output string
  if (.battery_percentage != 0) then
    "Battery at " + (.battery_percentage | tostring) + "%"
  else
    "Battery empty" 
  end
;

def drive:
  # Update the input's attributes as required
  if (.battery_percentage != 0) then
    {
      "battery_percentage": (.battery_percentage - 1),
      "distance_driven_in_meters": (.distance_driven_in_meters + 20),
      "nickname": .nickname
    }
  else
    .
  end
;

# Tests to run with:
#   $ jq -n -f remote-control-car.jq
#
# new_remote_control_car,
# new_remote_control_car("R2D2"),
# (new_remote_control_car | display_distance),
# (new_remote_control_car | display_battery),
# (new_remote_control_car("Red") | drive),
# ({
#   battery_percentage: 0,
#   distance_driven_in_meters: 2000,
#   nickname: "Red"
# } | drive)

# Hints

## General

- [Ruby Guides: Initialize Method][rg-initialize-method]
- [Ruby For Beginners: Instance variables][rfb-instance-variables]
- [Ruby Guides: Instance variables][rg-instance-variables]
- [Ruby User's Guide: Instance variables][rug-instance-variables]
- [Geeks for Geeks: Ruby Getters and Setters Methods][gfg-getter-setters]

## 1. Make new attendees

- Using the references, complete the initialize method to save the height to the object's state.

## 2. How tall is the attendee

- Create a getter for the saved height state.

## 3. What is the ride pass id

- Create a getter for the pass id.
- It is okay and expected to return `nil` before a pass is issued to the `Attendee`.

## 4. Allow people to buy a pass

- In the `Attendee#issue_pass!` method, set the instance's state to the argument.

## 4. Revoke the pass

- In the `Attendee#revoke_pass!` setter method set the instance's state so that no pass exists.

[rfb-instance-variables]: http://ruby-for-beginners.rubymonstas.org/writing_classes/instance_variables.html
[rg-initialize-method]: https://www.rubyguides.com/2019/01/ruby-initialize-method/
[rg-instance-variables]: https://www.rubyguides.com/2019/07/ruby-instance-variables/
[rug-instance-variables]: https://ruby-doc.org/docs/ruby-doc-bundle/UsersGuide/rg/instancevars.html
[gfg-getter-setters]: https://www.geeksforgeeks.org/ruby-getters-and-setters-method/
"""
    ispangram(input)

Return `true` if `input` contains every alphabetic character (case insensitive).

"""
function ispangram(input::String)::Bool
    Set("abcdefghijklmnopqrstuvwxyz") == Set(filter(isletter, lowercase(input)))
end


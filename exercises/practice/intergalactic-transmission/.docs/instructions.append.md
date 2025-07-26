# Instructions append

Although we're dealing with bytes of data, the inputs and outputs are `List<Integer>` (instead of `byte[]`) to avoid the need to cast or convert negative values for bytes 128 to 255.

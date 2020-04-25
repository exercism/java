class SatelliteTest {
    // TODO
}

/*

["a", "i", "x", "f", "r"]
["i", "a", "f", "x", "r"]

{
  "exercise": "satellite",
  "version": "2.0.0",
  "cases": [
    {
      "description": "Empty tree",
      "property": "treeFromTraversals",
      "input": {
        "preorder": [],
        "inorder": []
      },
      "expected": {}
    },
    {
      "description": "Tree with one item",
      "property": "treeFromTraversals",
      "input": {
          "preorder": ["a"],
          "inorder": ["a"]
      },
      "expected": {"v": "a", "l": {}, "r": {}}
    },
    {
      "description": "Tree with many items",
      "property": "treeFromTraversals",
      "input": {
          "preorder": ["a", "i", "x", "f", "r"],
          "inorder": ["i", "a", "f", "x", "r"]
      },
      "expected": {"v": "a",
          "l": {"v": "i", "l": {}, "r": {}},
          "r": {"v": "x",
              "l": {"v": "f", "l": {}, "r": {}},
              "r": {"v": "r", "l": {}, "r": {}}
          }
      }
    },
    {
      "description": "Reject traversals of different length",
      "property": "treeFromTraversals",
      "input": {
        "preorder": ["a", "b"],
        "inorder": ["b", "a", "r"]
      },
      "expected": {"error": "traversals must have the same length"}
    },
    {
      "description": "Reject inconsistent traversals of same length",
      "property": "treeFromTraversals",
      "input": {
          "preorder": ["x", "y", "z"],
          "inorder": ["a", "b", "c"]
      },
      "expected": {"error": "traversals must have the same elements"}
    },
    {
      "description": "Reject traversals with repeated items",
      "property": "treeFromTraversals",
      "input": {
        "preorder": ["a", "b", "a"],
        "inorder": ["b", "a", "a"]
      },
      "expected": {"error": "traversals must contain unique items"}
    }
  ]
}
*/
import HelloWorld from "./hello-world"

describe('Hello World', () => {

  it('says hello world with no name', () => {
    expect(HelloWorld.hello()).toEqual('Hello, World!')
  })

})

interface Handler<T> {
  setNext(handler: Handler<T>): Handler<T>
  handle(request: T): T | null
}

abstract class AbstractHandler<T> implements Handler<T> {
  private nextHandler?: Handler<T>

  setNext(handler: Handler<T>): Handler<T> {
    this.nextHandler = handler
    return handler
  }

  handle(request: T): T | null {
    if (this.nextHandler) {
      return this.nextHandler.handle(request)
    }

    return null
  }
}

class MonkeyHandler extends AbstractHandler<string> {
  public handle(request: string): string | null {
    if (request === 'Banana') {
      return `Monkey: I'll eat the ${request}.`
    }
    return super.handle(request)
  }
}

class SquirrelHandler extends AbstractHandler<string> {
  public handle(request: string): string | null {
    if (request === 'Nut') {
      return `Squirrel: I'll eat the ${request}.`
    }
    return super.handle(request)
  }
}

class DogHandler extends AbstractHandler<string> {
  public handle(request: string): string | null {
    if (request === 'MeatBall') {
      return `Dog: I'll eat the ${request}.`
    }
    return super.handle(request)
  }
}

function clientCode(handler: Handler<string>) {
  const foods = ['Nut', 'Banana', 'Cup of coffee']

  for (const food of foods) {
    console.log(`Client: Who wants a ${food}?`)

    const result = handler.handle(food)
    if (result) {
      console.log(`  ${result}`)
    } else {
      console.log(`  ${food} was left untouched.`)
    }
  }
}

const monkey = new MonkeyHandler()
const squirrel = new SquirrelHandler()
const dog = new DogHandler()

monkey.setNext(squirrel).setNext(dog)

clientCode(monkey)

clientCode(squirrel)

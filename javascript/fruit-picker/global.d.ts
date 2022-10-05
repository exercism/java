/**
 * These are the shapes of the external grocer service', the return values and the
 * functions. Don't change these. In various IDEs, such as vscode, this will add
 * type information on the fly
 */

type FruitPickerSuccess = {
  message: 'SUCCESS';
};

type FruitPickerError = {
  message: 'ERROR';
};

declare module 'notifier' {
  function notify(message: FruitPickerSuccess | FruitPickerError): void;
}

type GrocerQuery = {
  variety: string;
  quantity: number;
};

interface GrocerOnSuccessCallback {
  (quantityOrdered: number): void;
}

interface GrocerOnErrorCallback {
  (errorMessage: string): void;
}

declare module 'grocer' {
  function order(
    query: GrocerQuery,
    onSuccess: GrocerOnSuccessCallback,
    onError: GrocerOnErrorCallback
  ): void;
}

type FruitPickerSuccessCallback = () => SuccessResult;

type FruitPickerErrorCallback = () => ErrorResult;

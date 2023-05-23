const isBoolean = (value: string): boolean => {
  const truthy: string[] = ['true', 'True', '1'];
  return truthy.includes(value);
};

export { isBoolean };

export const GetMessages = (elem) => {
    const messages = [];
    if (elem.validity.valueMissing){
        messages.push("Value required");
    }
    if (elem.validity.typeMismatch){
        messages.push(`Invalid value of type ${elem.type}`)
    }
    return messages;
}
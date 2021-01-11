export type Product = {
    id: number,
    name: string,
    price: number,
    description: string,
    imageUri: string
}

export type ProductId = {
    id: number;
}

export type OrderPayload = {
    products: ProductId[];
} & OrderLocationData;

export type Order = {
    id: number,
    address: string,
    latitude: number,
    longitude: number,
    moment: Date,
    status: string,
    total: number,
    products: Product[],
}

export type OrderLocationData = {
    latitude: number;
    longitude: number;
    address: string;
}
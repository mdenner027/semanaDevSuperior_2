export type Product = {
    id: number,
    name: string,
    price: number,
    description: string,
    imageUri: string
}

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
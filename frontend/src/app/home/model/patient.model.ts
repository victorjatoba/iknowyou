import { BloodType } from './blood-type.model';

/**
 * User Model information.
 */
export interface Patient {
    id: string;
    name: string;
    address?: string;
    phone?: string;
    birthdate: string;
    bloodType: BloodType;
}

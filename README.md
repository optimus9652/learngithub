# 🏠 Real Estate Enterprise - AI-Powered Property Platform

A modern, full-stack real estate application built with Next.js, featuring an AI-powered chat assistant for intelligent property search and recommendations.

## ✨ Features

### 🤖 AI Chat Assistant
- **Natural Language Search**: "Show me 3-bedroom houses under $400k with a garage"
- **Smart Price Filtering**: Understands budget ranges and filters accurately
- **Amazon Bedrock Integration**: Uses Claude 3 Haiku for conversational AI
- **Fallback System**: Intelligent rule-based filtering when AI is unavailable
- **Real-time Recommendations**: Instant property suggestions based on conversation

### 🏡 Property Management
- **Dual User Roles**: Separate dashboards for customers and sellers
- **Property Listings**: Complete property details with images and amenities
- **Advanced Filtering**: Filter by price, type, location, bedrooms, amenities
- **Seller Dashboard**: Add, manage, and track property listings
- **Customer Dashboard**: Browse properties and chat with AI assistant

### 🔐 Authentication & Security
- **JWT Authentication**: Secure token-based authentication
- **Role-based Access**: Customer and seller role management
- **Password Hashing**: Secure password storage with bcryptjs
- **Protected Routes**: Secure API endpoints and pages

### 🎨 Modern UI/UX
- **Responsive Design**: Bootstrap 5 with custom styling
- **Interactive Components**: Hover effects and smooth animations
- **Chat Interface**: Modern chat bubbles with typing indicators
- **Property Cards**: Beautiful property display with image galleries
- **Mobile Friendly**: Optimized for all device sizes

## 🛠️ Tech Stack

### Frontend
- **Next.js 14.2.31** - React framework with App Router
- **React 18** - Modern React with hooks
- **Bootstrap 5** - Responsive CSS framework
- **React Bootstrap** - Bootstrap components for React
- **Font Awesome** - Icon library

### Backend
- **Next.js API Routes** - Serverless API endpoints
- **PostgreSQL** - Robust relational database
- **Node.js** - JavaScript runtime

### AI & Cloud
- **Amazon Bedrock** - AWS managed AI service
- **Claude 3 Haiku** - Anthropic's language model (free tier)
- **AWS SDK** - Bedrock client integration

### Development
- **ESLint** - Code linting
- **Git** - Version control

## 🚀 Quick Start

### Prerequisites
- Node.js 18+ 
- PostgreSQL 12+
- npm or yarn

### Installation

1. **Clone the repository**
   ```bash
   git clone <your-gitlab-repo-url>
   cd real-estate-nextjs
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Set up PostgreSQL**
   ```bash
   # Install PostgreSQL (Ubuntu/Debian)
   sudo apt update
   sudo apt install postgresql postgresql-contrib
   
   # Start PostgreSQL
   sudo systemctl start postgresql
   sudo systemctl enable postgresql
   
   # Create database and user
   sudo -u postgres psql -c "CREATE DATABASE realestate;"
   sudo -u postgres psql -c "CREATE USER realestateuser WITH PASSWORD 'password123';"
   sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE realestate TO realestateuser;"
   ```

4. **Configure environment variables**
   ```bash
   cp .env.example .env.local
   ```
   
   Update `.env.local` with your configuration:
   ```env
   # Database
   DB_USER=realestateuser
   DB_HOST=localhost
   DB_NAME=realestate
   DB_PASSWORD=password123
   DB_PORT=5432
   
   # Authentication
   JWT_SECRET=your-super-secret-jwt-key
   NEXTAUTH_SECRET=your-nextauth-secret-key
   NEXTAUTH_URL=http://localhost:3000
   
   # AWS Bedrock (Optional)
   AWS_REGION=us-east-1
   AWS_ACCESS_KEY_ID=your-aws-access-key
   AWS_SECRET_ACCESS_KEY=your-aws-secret-key
   ```

5. **Run the development server**
   ```bash
   npm run dev
   ```

6. **Access the application**
   - Open [http://localhost:3000](http://localhost:3000)
   - Use test accounts:
     - Customer: `customer@example.com` / `password123`
     - Seller: `seller@example.com` / `password123`

## 🤖 AI Assistant Setup

### Option 1: Rule-Based System (Default)
The application works immediately with an intelligent rule-based system that:
- Detects price ranges from natural language
- Filters by property type, location, and amenities
- Provides conversational responses
- Requires no external setup

### Option 2: Amazon Bedrock (Enhanced AI)
For advanced conversational AI:

1. **Create AWS Account** (free tier available)
2. **Enable Bedrock** in AWS Console (us-east-1 region)
3. **Request Model Access** for Claude 3 Haiku
4. **Add AWS credentials** to `.env.local`
5. **Uncomment Bedrock code** in `/app/api/chat/property-assistant/route.js`

**Free Tier Benefits:**
- 25,000 tokens/month with Claude 3 Haiku
- ~100-250 property searches per month
- Perfect for development and small-scale usage

## 📁 Project Structure

```
real-estate-nextjs/
├── app/                          # Next.js App Router
│   ├── api/                      # API routes
│   │   ├── auth/                 # Authentication endpoints
│   │   ├── chat/                 # AI chat assistant
│   │   └── properties/           # Property management
│   ├── auth/                     # Authentication pages
│   ├── dashboard/                # User dashboards
│   └── globals.css               # Global styles
├── components/                   # React components
│   └── PropertyChatAssistant.js  # AI chat component
├── lib/                          # Utility libraries
│   └── db.js                     # Database configuration
├── public/                       # Static assets
├── docs/                         # Documentation files
└── README.md                     # This file
```

## 🎯 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login

### Properties
- `GET /api/properties` - Get all properties
- `GET /api/properties/[id]` - Get property by ID
- `POST /api/properties` - Create new property (sellers only)
- `DELETE /api/properties/[id]` - Delete property (sellers only)

### AI Chat
- `POST /api/chat/property-assistant` - AI property recommendations

## 🎨 UI Components

### Chat Interface
- Modern chat bubbles with user/AI distinction
- Typing indicators and loading states
- Suggested conversation starters
- Real-time property recommendations

### Property Cards
- Image galleries with carousel
- Detailed property information
- Seller contact details
- Responsive grid layout

### Dashboards
- Customer: AI chat + property browsing
- Seller: Property management + analytics
- Tabbed interface for easy navigation

## 🔧 Development

### Available Scripts
```bash
npm run dev      # Start development server
npm run build    # Build for production
npm run start    # Start production server
npm run lint     # Run ESLint
```

### Database Schema
```sql
-- Users table
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  user_type VARCHAR(50) NOT NULL,
  phone VARCHAR(20),
  address TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Properties table
CREATE TABLE properties (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  price DECIMAL(12,2) NOT NULL,
  property_type VARCHAR(50) NOT NULL,
  bedrooms INTEGER NOT NULL,
  bathrooms INTEGER NOT NULL,
  area DECIMAL(10,2) NOT NULL,
  address TEXT NOT NULL,
  city VARCHAR(100) NOT NULL,
  state VARCHAR(100) NOT NULL,
  zip_code VARCHAR(20) NOT NULL,
  images TEXT[],
  amenities TEXT[],
  status VARCHAR(20) DEFAULT 'available',
  seller_id INTEGER REFERENCES users(id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 🚀 Deployment

### Vercel (Recommended)
1. Push code to GitLab
2. Connect GitLab repo to Vercel
3. Add environment variables in Vercel dashboard
4. Deploy automatically on push

### Manual Deployment
```bash
npm run build
npm start
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Merge Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Next.js** - Amazing React framework
- **Amazon Bedrock** - Powerful AI capabilities
- **PostgreSQL** - Reliable database
- **Bootstrap** - Beautiful UI components
- **Anthropic Claude** - Intelligent AI model

## 📞 Support

For support and questions:
- Create an issue in GitLab
- Check the documentation files in `/docs/`
- Review the setup guides for detailed instructions

---

**Built with ❤️ using Next.js, PostgreSQL, and Amazon Bedrock**
